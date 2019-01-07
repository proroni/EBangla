package root.android.workspaceit.com.ebangla;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import root.android.workspaceit.com.ebangla.Presenter.BooksPresenter;
import root.android.workspaceit.com.ebangla.View.IBooksView;
import root.android.workspaceit.com.ebangla.View.UI.Fragment.FragmentMylist;
import root.android.workspaceit.com.ebangla.View.UI.Fragment.Fragmenthome;

public class HOmeActivity extends AppCompatActivity {
    Fragment fragment = null;
    private TextView mTextMessage;
    BooksPresenter presenter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new Fragmenthome();
                    replaceFragment(fragment);
                    return true;

                case R.id.navigation_notifications:
                    fragment = new FragmentMylist();
                    replaceFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //select first page
        fragment = new Fragmenthome();
        replaceFragment(fragment);


        presenter=new BooksPresenter();




        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        }


}
