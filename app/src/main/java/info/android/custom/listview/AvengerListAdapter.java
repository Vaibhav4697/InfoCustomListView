package info.android.custom.listview;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

public class AvengerListAdapter extends ArrayAdapter<Avengers> {

    private List<Avengers> avengers;
    private Context context;
    private Integer resource;

    public AvengerListAdapter(@NonNull Context context, int resource, @NonNull List<Avengers> avengers) {
        super(context, resource, avengers);
        this.context = context;
        this.resource = resource;
        this.avengers = avengers;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View customListView = layoutInflater.inflate(resource, null, false);

        ImageView imageView = customListView.findViewById(R.id.image_view);
        TextView nameTextView = customListView.findViewById(R.id.name_text_view);
        TextView teamTextView = customListView.findViewById(R.id.team_text_view);
        Button deleteButton = customListView.findViewById(R.id.delete_button);

        Avengers avenger = avengers.get(position);

        imageView.setImageDrawable(context.getResources().getDrawable(avenger.getImage()));
        nameTextView.setText(avenger.getName());
        teamTextView.setText(avenger.getTeam());

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeAvenger(position);
            }
        });
        return customListView;
    }

    private void removeAvenger(final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete this?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                avengers.remove(position);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}
