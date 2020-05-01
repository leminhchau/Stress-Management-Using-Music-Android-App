package com.example.musicplayer;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class musicplayer extends Fragment {

    public musicplayer() {
        // Required empty public constructor
    }

    Button btn_next, btn_previous, btn_pause, btn_back;
    TextView songTextLabel;
    SeekBar songSeekbar;

    static MediaPlayer myMediaPlayer;
    int position;
    String sname;
    ArrayList<File> mySongs;
    Thread updateseekBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_musicplayer, container, false);

//        btn_back = (Button) v.findViewById(R.id.back);
//        btn_next = (Button) v.findViewById(R.id.next);
//        btn_previous = (Button) v.findViewById(R.id.previous);
//        btn_pause = (Button) v.findViewById(R.id.pause);
//
////        btn_back.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                currentmusic fragment = new currentmusic();
////                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
////                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////                fragmentTransaction.replace(R.id.viewpager, fragment);
////                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
////                fragmentTransaction.addToBackStack(null);
////                fragmentTransaction.commit();
////            }
////        });
//
//        songTextLabel = (TextView) v.findViewById(R.id.songLabel);
//
//        songSeekbar = (SeekBar) v.findViewById(R.id.seekBar);
//
//        updateseekBar = new Thread(){
//
//            @Override
//            public void run() {
//
//                int totalDuration = myMediaPlayer.getDuration();
//                int currentPosition = 0;
//
//                while (currentPosition < totalDuration){
//                    try{
//                        sleep(500);
//                        currentPosition = myMediaPlayer.getCurrentPosition();
//                        songSeekbar.setProgress(currentPosition);
//                    }
//                    catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//        };
//
//        if (myMediaPlayer!=null){
//            myMediaPlayer.stop();
//            myMediaPlayer.release();
//        }
//
////        Intent i = getActivity().getIntent();
//
//        Bundle bundle = getArguments();
//
//        mySongs  = (ArrayList) bundle.getParcelableArrayList("songs");
//
//        sname = mySongs.get(position).getName().toString();
//
//        String songName = bundle.getString("songname");
//
//        songTextLabel.setText(songName);
//        songTextLabel.setSelected(true);
//
//        position = bundle.getInt("pos", 0);
//
//        Uri u = Uri.parse(mySongs.get(position).toString());
//
//        myMediaPlayer = MediaPlayer.create(getActivity(),u);
//
//        myMediaPlayer.start();
//        songSeekbar.setMax(myMediaPlayer.getDuration());
//
//         songSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//             @Override
//             public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//
//             }
//
//             @Override
//             public void onStartTrackingTouch(SeekBar seekBar) {
//
//             }
//
//             @Override
//             public void onStopTrackingTouch(SeekBar seekBar) {
//                myMediaPlayer.seekTo(seekBar.getProgress());
//             }
//         });
        return v;
    }
}
