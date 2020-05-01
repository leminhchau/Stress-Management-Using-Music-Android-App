package com.example.musicplayer;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class currentmusic extends Fragment {

    public currentmusic() {
        // Required empty public constructor
    }


    String[] items;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_currentmusic, container, false);


        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        Dexter.withContext(getActivity())
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        final ListView myListViewForSongs  = (ListView)getActivity().findViewById(R.id.mySongListView);

                        final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());

                        items = new String[mySongs.size()];

                        for(int i = 0; i<mySongs.size();i++)
                        {
                            items[i] = mySongs.get(i).getName().toString().replace(".mp3","").replace(".wav","");

                        }

                        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, items);
                        myListViewForSongs.setAdapter(myAdapter);

                        myListViewForSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                String songName = myListViewForSongs.getItemAtPosition(i).toString();


                                musicplayer fragment = new musicplayer();
                                Bundle args = new Bundle();
                                args.putSerializable("songs", mySongs);
                                args.putString("songname", songName);
                                args.putInt("pos", i);
                                fragment.setArguments(args);
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.viewpager, fragment);
                                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();






//                                startActivity(new Intent(getActivity(),musicplayer.class).putExtra("songs", mySongs).putExtra("songname",songName).putExtra("pos",i));
                            }
                        });


                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast toast=Toast.makeText(getActivity(),"Sorry you dont have permission to access the songs",Toast.LENGTH_LONG);
                        toast.show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
        super.onActivityCreated(savedInstanceState);


    }
    public ArrayList<File> findSong(File file){

        ArrayList<File> arrayList = new ArrayList<>();

        File[] files = file.listFiles();
        for(File singleFile: files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                arrayList.addAll(findSong(singleFile));
            }
            else{
                if (singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav")){
                    arrayList.add(singleFile);
                }
            }
        }

        return arrayList;

    }




}
