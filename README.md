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

### Functional
- The app uses **LinkMyDeals** API to fetch the list of coupons.
- It **stores** all the coupons fetched from the API to the **database**.
- Each item in the list displays the title, description, image, coupon code and discounted price of the coupon.
- The app allows users to filter for coupons by store, and sort by expiry date.
- The app allows users to mark a coupon item as their favorite when users tap the **heart** icon.
- The app provides a way for users to view the details of each coupon by tapping on the coupon item in the list.
- The detailed view of each coupon displays the title, description, image, original price, discounted price, expiry date, and terms and conditions of the deal.
- The app allows users to remove a coupon item from their favorite when tapping the **trash** icon

### Technical
- Fully **Kotlin**
- Follows **Single activity, Multiple Fragments approach**
- Uses **MVVM** architecture
- Uses **Room ORM** to communicate with database
- Uses **Android Navigation Components** and **View Binding**

## Preview

<p float="left">
  <img src="/images/SplashScreen.jpg" width="300" />
  <img src="/images/DealsPage.jpg" width="300" />
  <img src="/images/FavoritesPage.jpg" width="300" />
  <img src="/images/DetailsPage.jpg" width="300" />
</p>