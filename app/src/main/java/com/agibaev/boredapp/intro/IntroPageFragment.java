package com.agibaev.boredapp.intro;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.agibaev.boredapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroPageFragment extends Fragment {

    private final static String ARG_TITLE_RES_ID ="title_res";
    private final static String ARG_IMAGE_RES_ID ="image_res";

    public IntroPageFragment() {
    }

    public static Fragment newInstance (IntroPageConfig config) {
        IntroPageFragment fragment = new IntroPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TITLE_RES_ID, config.getTitleRes());
        args.putInt(ARG_IMAGE_RES_ID, config.getImageRes());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_i, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv = view.findViewById(R.id.textView);
        tv.setText(getArguments().getInt(ARG_TITLE_RES_ID));

        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(getArguments().getInt(ARG_IMAGE_RES_ID));
    }
}
