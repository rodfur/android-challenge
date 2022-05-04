package androidchallenge.presentation

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

open class BaseActivity : AppCompatActivity() {

    protected fun setupToolbar(toolbar: Toolbar, showBackButton: Boolean = false) {
        setSupportActionBar(toolbar)
        if (showBackButton) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}