package sg.edu.np.mad.madpractical4;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
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
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);
        return  new UserViewHolder(item);

    }

    public void onBindViewHolder(UserViewHolder holder, int position) {
        Random random = new Random();
        int randomNumber = random.nextInt(1000000) + 1000000;
        User user = data.get(position);
        holder.name.setText(user.name + " " + randomNumber);
        holder.description.setText(user.description + " " + randomNumber);
        int lastDigit = 0; // Default value

        try {
            // Assuming you're parsing the last character(s) to get a number.
            lastDigit = Integer.parseInt(user.name.substring(user.name.length() - 1));
        } catch (NumberFormatException e) {
            // Handle invalid parsing.
            Log.e(TAG, "Failed to parse integer from name: " + user.name, e);
        }
        if (lastDigit == 7){
            holder.imageViewLarge.setVisibility(View.VISIBLE);
        }
        else{
            holder.imageViewLarge.setVisibility(View.GONE);
        }
        holder.imageViewSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Profile");
                builder.setMessage(user.name + randomNumber);
                builder.setCancelable(true);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent goToMainActivity = new Intent(context, MainActivity.class);
                        goToMainActivity.putExtra("randomNumber", randomNumber);
                        goToMainActivity.putExtra("name", user.name);
                        goToMainActivity.putExtra("description", user.description);
                        context.startActivity(goToMainActivity);
                    }
                });

                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
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
