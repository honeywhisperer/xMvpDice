package com.algebra.xmvpdice.six

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.algebra.xmvpdice.databinding.ItemDiceBinding

class DiceAdapter: RecyclerView.Adapter<DiceAdapter.DiceViewHolder>() {

    private val dices = mutableListOf<String>()


    var listener: OnItemDiceInteraction? = null

    fun initDiceValues(){
        dices.clear()
        dices.addAll(arrayOf("R", "O", "L", "L", "M", "E"))
        notifyDataSetChanged()
    }

    fun setDiceValue(dicePosition: Int, newValue: String){
        dices[dicePosition] = newValue
        notifyItemChanged(dicePosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiceViewHolder {
        val itemDiceBinding = ItemDiceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiceViewHolder(itemDiceBinding)
    }

    override fun onBindViewHolder(holder: DiceViewHolder, position: Int) {
        holder.bind(dices[position])
    }

    override fun getItemCount(): Int {
        return dices.size
    }

    inner class DiceViewHolder(private val itemDiceBinding: ItemDiceBinding) : RecyclerView.ViewHolder(itemDiceBinding.root){
        init {
            itemDiceBinding.btnDice.setOnClickListener {
                listener?.onDiceClick(layoutPosition)
            }
        }
        fun bind(value: String){
            itemDiceBinding.btnDice.text = value
        }
    }
}

interface OnItemDiceInteraction{
    fun onDiceClick(dicePosition: Int)
}