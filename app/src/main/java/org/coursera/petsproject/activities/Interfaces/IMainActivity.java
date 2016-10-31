package org.coursera.petsproject.activities.Interfaces;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * Created by Victor Daniel Cortés Restrepo on 17/10/16.
 */

public interface IMainActivity {

    public ArrayList<Fragment> addFragments();

    public void setUPViewPager();

    public void goFavoritePets();

    public void goAbout();

    public void goContact();

    public void goConfiguration();

    public void recibirNotificaciones();
}
