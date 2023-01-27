package com.sinx.project.decoration

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView

class DividerItemDecoration(
	private val context: Context,
	private val resId: Int
) : RecyclerView.ItemDecoration() {

	private val mDivider: Drawable?
		get() = ContextCompat.getDrawable(context, resId)

	/**
	 * с какой позиции начать устанавливать декоратор
	 * */
	private var dividerStartPosition: Int = 0

	/**
	 * нужно ли отрисовывать декоратор у последнего элемента
	 */
	private var isDrawLastItem: Boolean = true


	override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
		super.onDrawOver(c, parent, state)

		val itemCount = parent.adapter?.itemCount ?: 0


		c.save()


		parent.children.forEachIndexed { viewIndex, childView ->
			/**
			 * Сейчас разделитель отрисовывается начиная с индекса=3 (4й элемент в списке) и заканчивая предпоследним.
			 * Можно посмотреть как будет отрисовываться начиная с любого индекса, меняя входные параметры в [ProjectFragment.kt]
			 * decorator.setStartPosition(3) и decorator.setIsDrawLastItem(false)
			 *
			 * В RecyclerView при пролистывании списка на экране отрисовывается только n-ное количество вьюшек (которые влезли +
			 * по одному сверху и снизу), с данным этого списка необходимо работать через адаптер
			 *
			 *
			 * кусок кода ниже работает некорректно.
			 * необходимо на вход функции needDrawItem передать индекс не текущей вью в списке,
			 * а индекс из адаптера списка (адаптер знает, какой элемент списка сейчас отображается).
			 *
			 */
			if (needDrawItem(viewIndex, itemCount)) {
				setUpBounds(mDivider, childView)?.draw(c)
			}
		}

		c.restore()
	}

	/**
	 * функция для определения того, нужно ли в текущий момент времени рисовать у итема декоратор
	 */
	private fun needDrawItem(currentItemIndex: Int, itemCount: Int): Boolean {
		val isLast = currentItemIndex == itemCount - 1
		val needDrawCurrent = currentItemIndex >= dividerStartPosition && !isLast
		val needDrawLast = isDrawLastItem && isLast
		return needDrawCurrent || needDrawLast
	}


	/**
	 * вычисляем в какой точке экрана рисовать декоратор
	 */
	private fun setUpBounds(divider: Drawable?, view: View): Drawable? {
		val dividerHeight = divider?.intrinsicHeight ?: 0

		val dividerTop = view.bottom
		val dividerBottom = view.bottom + dividerHeight + view.paddingBottom
		val dividerLeft = view.left + view.paddingLeft
		val dividerRight = view.right + view.paddingRight

		divider?.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)

		return divider
	}


	fun setStartPosition(position: Int) {
		dividerStartPosition = position
	}

	fun setIsDrawLastItem(needDraw: Boolean) {
		isDrawLastItem = needDraw
	}

	companion object {
		const val DIVIDER_LEFT = 88
	}

}