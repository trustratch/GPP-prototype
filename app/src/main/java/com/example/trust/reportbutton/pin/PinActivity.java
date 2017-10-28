package com.example.trust.reportbutton.pin;

import com.github.omadahealth.lollipin.lib.managers.AppLockActivity;



public class PinActivity extends AppLockActivity {

    @Override
    public void showForgotDialog() {

    }

    @Override
    public void onPinFailure(int attempts) {

    }

    @Override
    public void onPinSuccess(int attempts) {

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public int getPinLength() {
        return 6;
    }
}
