package sg.edu.np.mad.madpractical4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView imageViewSmall, imageViewLarge;


    TextView name;
    TextView description;

    public UserViewHolder (View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        description = itemView.findViewById(R.id.description);
        imageViewSmall = itemView.findViewById(R.id.profileSmall);
        imageViewLarge = itemView.findViewById(R.id.bigImage);
        imageViewLarge.setVisibility(View.GONE);

    }
}