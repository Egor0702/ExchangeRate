package com.example.exchangerate.domain.core

sealed class BusLogic<out F, out R> {
    /** * Представляет левую часть [Either] класса, которая по соглашению является "Failure */
    data class Failed<out F>(val a: F) : BusLogic<F, Nothing>()

    /** * Представляет правую часть [Either] класса, которая по соглашению является "Success". */
    data class Rightable<out R>(val b: R) : BusLogic<Nothing, R>()

    val isRightable get() = this is Rightable<R>  // возвращает булево значение - является ли объект Either типом Righ
    val isFailed get() = this is Failed<F> // возвращает булево значение - является ли объект Either типом Left

    fun <L> failed(a: L) = Failed(a)
    fun <R> righttable(b: R) = Rightable(b)

    fun busLogic(functionLeft: (F) -> Any, functionRight: (R) -> Any): Any =
        // данный метод выполняет одну
        when (this) {                                                      //из двух функций высшего порядка
            is Failed -> functionLeft(a) // если объект Left, то выполняется функция functionLeft
            is Rightable -> functionRight(b)// если объект Right, то выполняется функция functionRight
        }
}
    fun <A, B, C> ((A) -> B).compose(f: (B) -> C): (A) -> C = {
        f(this(it))
    }

    fun <T, L, R> BusLogic<L, R>.flatMap(fn: (R) -> BusLogic<L, T>): BusLogic<L, T> {
        return when (this) {
            is BusLogic.Failed -> BusLogic.Failed(a)
            is BusLogic.Rightable -> fn(b)
        }
    }


//fun <T, L, R> Either<L, R>.map(fn: (R) -> (T)): Either<L, T> {
//    return this.flatMap(fn.compose(::right))
//}
//
//fun <L, R> Either<L, R>.onNext(fn: (R) -> Unit): Either<L, R> {
//    this.flatMap(fn.compose(::right))
//    return this
//}
