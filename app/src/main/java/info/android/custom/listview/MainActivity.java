package info.android.custom.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Avengers> avengers;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avengers = new ArrayList<>();
        listView = findViewById(R.id.list_view);

        avengers.add(new Avengers("Spiderman", "Avengers", R.drawable.spider_man));
        avengers.add(new Avengers("Black Widow", "Avengers", R.drawable.black_widow));
        avengers.add(new Avengers("Captain America", "Avengers", R.drawable.captain_america));
        avengers.add(new Avengers("Clint Barton", "Avengers", R.drawable.clint_barton));
        avengers.add(new Avengers("Dead Pool", "Avengers", R.drawable.dead_pool));
        avengers.add(new Avengers("Hulk", "Avengers", R.drawable.hulk));
        avengers.add(new Avengers("Iron Man", "Avengers", R.drawable.iron_man));
        avengers.add(new Avengers("Thor", "Avengers", R.drawable.thor));
        avengers.add(new Avengers("Wanda Maximoff", "Avengers", R.drawable.wanda_maximoff));
        avengers.add(new Avengers("Ant Man", "Avengers", R.drawable.ant_man));

        AvengerListAdapter avengerListAdapter = new AvengerListAdapter(this, R.layout.custom_list, avengers);
        listView.setAdapter(avengerListAdapter);
    }
}
