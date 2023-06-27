# Green Deals

Green Deals shows Coupons & Deals from stores. It displays deals fetched from [LinkMyDeals](https://linkmydeals.com/).

## Dependencies

- [Retrofit](https://github.com/square/retrofit): A type-safe HTTP client for Android and Java.
- [Glide](https://github.com/bumptech/glide): Fast and efficient open source media management and image loading framework for Android
- [LinkMyDeals API](https://linkmydeals.com/): Real-time Coupons & Deals from 2000+ stores with customized data.

## Information

[LinkMyDeals API](https://linkmydeals.com/) only allows `25` request per day, I advise you to change the `API_KEY`
inside [DealsService](app/src/main/java/com/kidusmichaelworku/discountdealslist/services/DealsService.kt).

You can do this by replacing the `{YOUR_API_KEY}` string shown below in the `GET` request of the interface with your `API_KEY`.

```kotlin
@GET("/getOffers/?API_KEY={YOUR_API_KEY}&format=json")
suspend fun getOffers(): Response
```

## Features

- 100% Kotlin
- Single activity, Multiple Fragments
- MVVM
- Room ORM
- Navigation Components
- View Binding

## Preview

<p float="left">
  <img src="/images/SplashScreen.jpg" width="100" />
  <img src="/images/DealsPage.jpg" width="100" />
  <img src="/images/FavoritesPage.jpg" width="100" />
  <img src="/images/DetailsPage.jpg" width="100" />
</p>