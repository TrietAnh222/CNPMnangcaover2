package com.example.cnpmnangcaoriu;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cnpmnangcaoriu.Adapter.Cartadapter;

public class SwipeToDeleteCallback extends ItemTouchHelper.Callback {

    private final SwipeToDeleteListener mListener;

    public SwipeToDeleteCallback(Cartadapter listener) {
        mListener = listener;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // Thiết lập chuyển động cho vuốt qua trái (xóa)
        int swipeFlags = ItemTouchHelper.START;
        return makeMovementFlags(0, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        // Không xử lý di chuyển
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        // Xử lý sự kiện khi mục bị vuốt qua trái (xóa)
        if (mListener != null) {
            mListener.onSwipe(viewHolder.getAdapterPosition());
        }
    }
}
