# Priority
 A sample preferences based API. Preference for various incidents and corresponding mind-set in them

MongoDB database has been used.<br>
Property is corresponding-mind-set in those phases/areas of daily-life. For example Priority_Value, Satisfaction_Level, Key_Notes, Future_Planning etc.

Various End Points are:

@GetMapping("/getAreas") <br>
get all the areas to consider. These areas are equivalent to various phases in daily-life like Relationships, SocialWork etc. <br>

@PostMapping("/addArea/{area}") <br>
Add new Area to Database. This requires authentication via authentication-key as request parameter. For the time being, this key is not there in database rather it's hardcoded in application.properties file.. to keep things simple.<br>

@PostMapping("/addProperty/{property}")<br>
Same as above, add new property to database. Requires authentication-key as request parameter.<br>


@PostMapping("/addRatings/{name}/{area}/{property}/{value}")<br>
Now this is specially designed url. It requires name of user, area in which user wanna put ratings/preference-value, property(mind-set) which user wanna populate for given area, value of that property.	
