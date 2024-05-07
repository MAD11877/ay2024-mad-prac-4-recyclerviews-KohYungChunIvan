package sg.edu.np.mad.madpractical4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView txtName;
    TextView txtDescription;
    ImageView imgUser;

    public UserViewHolder(View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.textView2);
        txtDescription = itemView.findViewById(R.id.textView3);
        imgUser = itemView.findViewById(R.id.imageView5);

    }
}
