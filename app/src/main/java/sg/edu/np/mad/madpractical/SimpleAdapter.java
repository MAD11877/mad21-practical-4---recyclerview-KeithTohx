package sg.edu.np.mad.madpractical;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
    ArrayList<User> userList;
    Context context;

    public SimpleAdapter(Context cc, ArrayList<User> List) {
        context = cc;
        userList = List;
    }

    /*public SimpleAdapter(ArrayList<User> input){
        data = input;
    }*/

    @NonNull
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item;
        if(viewType == 1) {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.simplerecyclerview, parent, false);
        }
        else{
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.simplerecyclerview2, parent, false);
        }
        return new SimpleViewHolder(item);
    }

    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position){
        User userObj = userList.get(position);

        holder.txt1.setText(userObj.getName());
        holder.txt2.setText(userObj.getDescription());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Profile");
                builder.setMessage(userObj.getName());
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, MainActivity.class);
                        Bundle extras = new Bundle();
                        extras.putString("userName", userObj.getName());
                        extras.putString("userDesc", userObj.getDescription());
                        extras.putBoolean("followStatus", userObj.isFollowed());
                        intent.putExtras(extras);

                        context.startActivity(intent);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public int getItemCount(){
        return userList.size();
    }

    @Override
    public int getItemViewType(int position){
        String uName = userList.get(position).getName();
        int lastChar = Integer.parseInt(uName.substring(uName.length() - 1));

        if(lastChar == 7){
            return 0;
        }
        else{
            return 1;
        }
    }
}
