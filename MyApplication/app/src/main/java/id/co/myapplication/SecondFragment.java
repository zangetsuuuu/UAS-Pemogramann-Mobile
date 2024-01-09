package id.co.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private ImageView imgMegamind;
    private ImageView imgBossBaby;
    private ImageView imgSeaBeast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dua, container, false);

        imgMegamind = view.findViewById(R.id.imgMegamind);
        imgBossBaby = view.findViewById(R.id.imgBossBaby);
        imgSeaBeast = view.findViewById(R.id.imgSeaBeast);

        imgMegamind.setOnClickListener(v -> playVideo("megamind"));

        imgBossBaby.setOnClickListener(v -> playVideo("boss_baby"));

        imgSeaBeast.setOnClickListener(v -> playVideo("sea_beast"));

        return view;
    }

    private void playVideo(String videoFileName) {
        String videoPath = "android.resource://" + requireActivity().getPackageName() + "/raw/" + videoFileName;
        Uri videoUri = Uri.parse(videoPath);

        Intent intent = new Intent(requireContext(), VideoActivity.class);
        intent.putExtra("VIDEO_URI", videoUri.toString());
        startActivity(intent);
    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Konstruktor publik kosong yang diperlukan
    }

    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
}
