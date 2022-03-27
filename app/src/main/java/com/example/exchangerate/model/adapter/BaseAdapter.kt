package com.example.exchangerate.model.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<VH : BaseAdapter.BaseViewHolder> : RecyclerView.Adapter<VH>() { //базовый класс адаптера
    init {
        Log.d("Egor", "Всем хло, мы в BaseAdapter")
    }

    var items: MutableMap<String, Double> = mutableMapOf() // элементы списка, которые будут выводиться в RecyclerView
    var itemsKeys: MutableSet<String> = mutableSetOf()

    abstract val layoutRes: Int // id макета элемента списка

    abstract fun createHolder(view: View, viewType: Int): VH // функция, создающая ViewHolder, будет реализована в классах-наследниках

    override fun getItemCount(): Int { // возвращает количество элементов в списке
        Log.d("Egor", "BaseAdapter getItemCount()")
        return items.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        Log.d("Egor", "BaseAdapter onBindViewHolder()")
        getItem(holder, position) // с помощью данного метода заполняет макет данными
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        Log.d("Egor", "BaseAdapter onCreateViewHolder()")
        val v = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        return createHolder(v, viewType)
    }


    fun getItem(holder:VH, position: Int){ // возвращает из списка элемент
        val item: String = itemsKeys.elementAt(position)
        Log.d("Egor","Item: ${item} ${items[item]}")
        holder.bind(item, items[item])
    }

    fun add(newItems: MutableMap<String, Double>)  {
        Log.d("Egor", "BaseAdapter add")
        items = newItems
        itemsKeys = newItems.keys
    }

    fun clear() = items.clear()


    abstract class BaseViewHolder(protected val view: View) : RecyclerView.ViewHolder(view) { // базовый вьюхолдер для базового адаптера
        protected abstract fun onBind(name: String, valueNumber : Double?) // абстрактная функция, заполняющая макет элемента списка данными

        fun bind(name: String, value : Double?) { //присваивает элемент списка вью холдеру
            onBind(name, value) // делегириуем заполнение вьюхолдера onBind
        }

    }
}