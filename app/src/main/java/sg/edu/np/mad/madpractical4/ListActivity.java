package sg.edu.np.mad.madpractical4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("Ben","Engineer", 2, true));
        userList.add(new User("Alice", "Doctor", 3, false));
        userList.add(new User("Charlie", "Teacher", 4, true));
        userList.add(new User("Daisy", "Nurse", 5, true));
        userList.add(new User("Edward", "Lawyer", 6, false));
        userList.add(new User("Fiona", "Architect", 7, true));
        userList.add(new User("George", "Scientist", 8, false));
        userList.add(new User("Hannah", "Engineer", 9, true));
        userList.add(new User("Ian", "Musician", 10, false));
        userList.add(new User("Jane", "Chef", 11, true));
        userList.add(new User("Kevin", "Artist", 12, true));
        userList.add(new User("Lucy", "Designer", 13, false));
        userList.add(new User("Michael", "Actor", 14, true));
        userList.add(new User("Nina", "Journalist", 15, false));
        userList.add(new User("Oscar", "Photographer", 16, true));
        userList.add(new User("Paula", "Writer", 17, false));
        userList.add(new User("Quincy", "Athlete", 18, true));
        userList.add(new User("Rachel", "Pilot", 19, true));
        userList.add(new User("Sam", "Paramedic", 20, false));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        UserAdapter mAdapter = new UserAdapter(userList, this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}