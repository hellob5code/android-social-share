# GETTING STARTED #

This library allows you to easily add social network you want for share purposes. It deals of check if the user have the choosen social networks installed on it's device and trigger the intent in an easy way.

## 1. SetUp ##

Using gradle:
* Download project
* Import socialshare module
* Add to build.gradle dependencies the folowing line:
```
compile project (':socialshare')
```

## 2. Initialize #

### 2.1. All available networks ###

```java
final SocialShare socialShare = new SocialShare(context);
socialShare.setSubject("I am a subject");
socialShare.setMessage("And I am a really interesting message for share");
```

### 2.2. Only networks I want ###

```java
ArrayList<Integer> networksIWant = new ArrayList<>();
networksIWant.add(SocialNetwork.WHATSAPP);
networksIWant.add(SocialNetwork.FACEBOOK);
networksIWant.add(SocialNetwork.TWITTER);
networksIWant.add(SocialNetwork.INSTAGRAM);

final SocialShare socialShare = new SocialShare(context, networksIWant);
socialShare.setSubject("I am a subject");
socialShare.setMessage("And I am a really interesting message for share");
```

### 2.3. Networks I want and custom images ###

```java
final ArrayList<Integer> networksIWant = new ArrayList<>();
networksIWant.add(SocialNetwork.WHATSAPP);
networksIWant.add(SocialNetwork.FACEBOOK);
networksIWant.add(SocialNetwork.TWITTER);
networksIWant.add(SocialNetwork.INSTAGRAM);

final SocialImages customImages = new SocialImages();
customImages.setWhatsappImage(R.drawable.whatsapp);
customImages.setFacebookImage(R.drawable.facebook);
customImages.setTwitterImage(R.drawable.twitter);
customImages.setInstagramImage(R.drawable.instagram);

final SocialShare socialShare = new SocialShare(context, networksIWant, customImages);
socialShare.setSubject("I am a subject");
socialShare.setMessage("And I am a really interesting message for share");
```


### 2.4. All networks and custom images ###

```java
/* int whatsappImage, int facebookImage, int twitterImage, int instagramImage, 
int googleImage, int telegramImage, int gmailImage, int linkedinImage, 
int vineImage, int hangoutsImage, int pinterestImage, int lineImage, int snapchatImage */

final SocialImages customImages = new SocialImages(R.drawable.whatsapp, R.drawable.facebook, /* add all ... */);

final SocialShare socialShare = new SocialShare(context, customImages);
socialShare.setSubject("I am a subject");
socialShare.setMessage("And I am a really interesting message for share");
```


## 3. Build and use the view ##

### 3.1. Default view ###

```java
// Build view
final View v = socialShare.getDefaultShareUI();

// Do something with the view, for example show in Dialog
final Dialog d = new Dialog(MainActivity.this);
d.requestWindowFeature(Window.FEATURE_NO_TITLE);
d.addContentView(v, new ViewGroup.LayoutParams(
	ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
d.show();
```

### 3.2. Custom view: GridView ###

```java
// You have here a list with id / image of each network, use how you want
final ArrayList<SocialNetwork> items = getSocialNetworkList();

// For example in a GridView
final GridView gridview = (GridView) findViewById(R.id.grid);

// Make a custom adapter
gridview.setAdapter(new ImageAdapter(context, items));

// And add actions for each social network
gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// Get clicked object
        	final SocialNetwork network = items.get(position);

		// Start intent (pass the id of each social network)
        	shareIntentById(network.getId());
            }
        });
```

### 3.3. Custom view: Directly in a LinearLayout ###

```java
final ArrayList<SocialNetwork> items = getSocialNetworkList();
final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.socialNetworkLayout);

for (int i = 0; i < items.size; i++) {
	final SocialNetwork network = items.get(i);
	
	// Create pic for each social network
	final ImageView iv = new ImageView(context);
	iv.setImageResource(network.getImage());
	
	// Do something when click
	iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

		// Start share intent
                shareIntentById(network.getId());
            }
        });

	linearLayout.addView(iv);
}
```


