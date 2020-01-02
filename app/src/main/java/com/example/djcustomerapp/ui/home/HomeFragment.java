package com.example.djcustomerapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.djcustomerapp.DJBookActivity;
import com.example.djcustomerapp.HistoryActivity;
import com.example.djcustomerapp.PaymentActivity;
import com.example.djcustomerapp.R;
import com.example.djcustomerapp.ui.djlist.GalleryFragment;
import com.example.djcustomerapp.ui.slideshow.SlideshowFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends Fragment implements ViewPagerEx.OnPageChangeListener, BaseSliderView.OnSliderClickListener {

    private HomeViewModel homeViewModel;
    SliderLayout sliderLayout;
    HashMap<String, String> HashMapForURL;
    HashMap<String, Integer> HashMapForLocal;
    EditText search;
    private ListView listView;
    ArrayAdapter<String>adapter;
    ArrayList<HashMap<String,String>>songlist;
    CardView cardvdjlist,cardvbookdj,cardvhistory,cardvpayment;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        AddImageUrlLocal();

        sliderLayout = root.findViewById(R.id.slider);
        search = getActivity().findViewById(R.id.searchbar);
        cardvdjlist = root.findViewById(R.id.cardViewDJList);
        cardvbookdj = root.findViewById(R.id.cardViewBookDJ);
        cardvhistory = root.findViewById(R.id.cardViewHistory);
        cardvpayment = root.findViewById(R.id.cardViewPayment);

        cardvdjlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new GalleryFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.drawer_layout, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        cardvbookdj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DJBookActivity.class);
                startActivity(i);

            }
        });

        cardvpayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PaymentActivity.class);
                startActivity(i);

            }
        });

        cardvhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), HistoryActivity.class);
                startActivity(i);
            }
        });


//        String song[]={"agar tum n hote","girlfriboyfriend","abc","pooja","priya","gkk","ggi","yiuyi","gygu"};
//        listView = root.findViewById(R.id.listView);
//        adapter = new ArrayAdapter<String>(getContext(),R.layout.list_item, R.id.songs, song);
//        listView.setAdapter(adapter);


        for (String name : HashMapForLocal.keySet()) {
            TextSliderView textSliderView = new TextSliderView(root.getContext());

            textSliderView.description(name).image(HashMapForLocal.get(name)).setScaleType(BaseSliderView.ScaleType.CenterCrop).setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(HomeFragment.this);


        return root;
    }

    private void AddImageUrlLocal() {
        HashMapForLocal = new HashMap<String, Integer>();

        HashMapForLocal.put("LetsDance", R.drawable.dj3);
        HashMapForLocal.put("DiscoDance", R.drawable.sliderdj1);
        HashMapForLocal.put("JustNachoo", R.drawable.sliderdj2);
        HashMapForLocal.put("EnjoyTheBestDJ", R.drawable.sliderdj3);


    }

    @Override
    public void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}