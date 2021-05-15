package sg.edu.np.mad.madpractical;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    TextView txt1;
    TextView txt2;
    ImageView img;

    public SimpleViewHolder(View itemView){
        super(itemView);
        txt1 = itemView.findViewById(R.id.nameText2);
        txt2 = itemView.findViewById(R.id.descText2);
        img = itemView.findViewById(R.id.imageViewS);
    }
}
