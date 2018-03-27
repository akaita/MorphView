# MorphView
A convenience library for reversible AnimatedVectorDrawables

<img src="example.gif" width="300" />

# Usage

```groovy
'com.akaita.android:morphview:1.0.0' 
```

```xml
<com.akaita.android.morphview.MorphView
    android:id="@+id/morphView"
    android:layout_width="100dp"
    android:layout_height="100dp"
    app:avdFirst="@drawable/avd_favorite_to_send"
    app:avdSecond="@drawable/avd_send_to_favorite" />
```

```kotlin
override fun onResume() {
    favoriteButton.setOnClickListener { morphView.showAvdFirst() }
    toggleButton.setOnClickListener { morphView.morph() }
    sendButton.setOnClickListener { morphView.showAvdSecond() }
}
```
