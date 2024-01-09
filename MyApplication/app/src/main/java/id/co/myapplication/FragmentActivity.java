 package id.co.myapplication;

 import android.os.Bundle;
 import android.widget.FrameLayout;

 import androidx.annotation.NonNull;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.fragment.app.Fragment;
 import androidx.fragment.app.FragmentTransaction;
 import com.google.android.material.tabs.TabLayout;
 import com.google.android.material.bottomnavigation.BottomNavigationView;

 public class FragmentActivity extends AppCompatActivity {

     private FrameLayout frameLayout;
     private TabLayout tabLayout;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_fragment);


         frameLayout = findViewById(R.id.framelayout);
         tabLayout = findViewById(R.id.tablayout);

         getSupportFragmentManager().beginTransaction()
             .replace(R.id.framelayout, new FirstFragment())
             .addToBackStack(null)
             .commit();

         tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {
                 Fragment fragment = null;

                 switch (tab.getPosition()) {
                     case 0:
                         fragment = new FirstFragment();
                         break;
                     case 1:
                         fragment = new SecondFragment();
                         break;
                     case 2:
                         fragment = new ThirdFragment();
                         break;
                 }

                 getSupportFragmentManager().beginTransaction()
                     .replace(R.id.framelayout, fragment)
                     .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                     .commit();
             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {
                 // Handle tab unselected
             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {
                 // Handle tab reselected
             }
         });
     }
 }
