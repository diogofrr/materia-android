package devandroid.diogoferreira.aplicativolistadecompras.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import devandroid.diogoferreira.aplicativolistadecompras.R;
import devandroid.diogoferreira.aplicativolistadecompras.controller.ShoppingListController;
import devandroid.diogoferreira.aplicativolistadecompras.model.Item;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<Item> itemList;
    private ShoppingListController shoppingListController;

    public ItemAdapter(List<Item> itemList, ShoppingListController controller) {
        this.itemList = itemList;
        this.shoppingListController = controller;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Item currentItem = itemList.get(position);
        holder.itemNameTextView.setText(currentItem.getName());

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoppingListController.deleteItem(currentItem.getId());
                itemList.remove(currentItem);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTextView;
        ImageButton deleteButton;

        ItemViewHolder(View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.itemNameTextView);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
