package root.android.workspaceit.com.ebangla.View.UI.Fragment;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import root.android.workspaceit.com.ebangla.Model.Books;
import root.android.workspaceit.com.ebangla.Model.Preferance.PreferanceEBangla;
import root.android.workspaceit.com.ebangla.R;
import root.android.workspaceit.com.ebangla.View.IAdapterBookView;
import root.android.workspaceit.com.ebangla.View.IPreferenceView;
import root.android.workspaceit.com.ebangla.View.UI.Adapter.AdapterBookList;
import root.android.workspaceit.com.ebangla.View.UI.Adapter.AdapterTopBookList;

public class FragmentMylist extends Fragment implements IPreferenceView,IAdapterBookView {
    RecyclerView recyclerView;
    Button btnBuy;
    AdapterBookList adapterBookList;
    List<Books> books=new ArrayList<>();
    PreferanceEBangla preferanceEBangla;
    BottomSheetBehavior bottomSheetBehavior;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_list, container, false);
        preferanceEBangla= new PreferanceEBangla(getContext());
        books= new ArrayList<>(preferanceEBangla.getFavorites(getContext()));

        recyclerView=view.findViewById(R.id.rc_wish_list);
        btnBuy=view.findViewById(R.id.buy_book);

        LinearLayout linearLayout=view.findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(linearLayout);

        setBookAdapter();

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged( View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {

                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {

                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide( View bottomSheet, float slideOffset) {

            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                }
            }
        });

        return view;

    }

    @Override
    public void getCartList(List<Books> books) {

    }

    @Override
    public void setBookAdapter() {
        adapterBookList= new AdapterBookList(getContext(),books);//
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapterBookList);
    }

    @Override
    public void setTopBookAdapter() {

    }

    @Override
    public void setBookCategory() {

    }
}
