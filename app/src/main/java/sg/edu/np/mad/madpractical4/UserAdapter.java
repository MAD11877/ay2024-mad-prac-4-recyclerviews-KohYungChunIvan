package sg.edu.np.mad.madpractical4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> data;
    Context context;
    public UserAdapter(ArrayList<User> input, Context context) {
        this.data = input;
        this.context = context;
    }


    public UserViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(
                android.R.layout.simple_list_item_1,
                parent,
                false);
        return  new UserViewHolder(item);

    }

    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = data.get(position);
        holder.txtName.setText(user.name);
        holder.txtDescription.setText(user.description);
        holder.imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Profile")
                        .setMessage(user.name)
                        .setCancelable(true)
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Random random = new Random();
                                int randomNumber = random.nextInt(1000000) + 1;
                                Intent goToMainActivity = new Intent(context, MainActivity.class);
                                goToMainActivity.putExtra("name", user.name + randomNumber);
                                goToMainActivity.putExtra("description", user.description);
                                v.getContext().startActivity(goToMainActivity);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });
    }

    public int getItemCount() {
        return data.size();
    }

}
