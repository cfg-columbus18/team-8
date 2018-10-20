package com.example.deepakwarrier.growth;

        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;
        import com.bumptech.glide.Glide;
        import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {
    private List<MyContacts> myContacts;
    //    private Context context;
    private MyClickListener listener;

    ContactsAdapter(List<MyContacts> myContacts,MyClickListener listener) {
        this.myContacts = myContacts;
//        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_item_layout,viewGroup,false);
        return new ContactsViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        MyContacts contacts = myContacts.get(position);
        holder.displayName.setText(contacts.getContactName());
        holder.phoneNumber.setText(contacts.getContactNumber().get(0));
//        holder.displayImage.setImageBitmap(contacts.getContactImage());
        Glide
                .with(holder.itemView.getContext())
                .load(contacts.getContactImage())
                .into(holder.displayImage);
    }

    @Override
    public int getItemCount() {
        return myContacts.size();
    }

    static class ContactsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView displayName;
        private TextView phoneNumber;
        private ImageView displayImage;
        //        private Context context;
        private MyClickListener listener;

        ContactsViewHolder(@NonNull final View itemView, MyClickListener listener) {
            super(itemView);
//            this.context = context;
            this.listener = listener;
            this.displayName = itemView.findViewById(R.id.contact_name);
            this.phoneNumber = itemView.findViewById(R.id.contact_mobile);
            this.displayImage = itemView.findViewById(R.id.contact_image);
            itemView.setOnClickListener(this);
//            this.displayImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(itemView.getContext(), "OnClick...", Toast.LENGTH_SHORT).show();
            listener.onItemClick(view,getAdapterPosition());
//            listener.onImageClick(view,getAdapterPosition());
        }
    }
}