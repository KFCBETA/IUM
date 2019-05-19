from django.db import models

# Create your models here.
## profile model
class Profile(models.Model):
    profile_id = models.AutoField(primary_key=True)
    user_name = models.CharField(max_length=50)
    email = models.EmailField()

    def __str__(self):
        return "profile_id: %s, user_name: %s, email: %s" %(self.profile_id, self.user_name, self.email)
## bio model, for testing
class Bio(models.Model):
    profile = models.OneToOneField(
        Profile,
        on_delete=models.CASCADE,
        primary_key=True,
    )
    bio_text = models.TextField()

    def __str__(self):
        return self.bio_text

## 'twitter' account model, to be added
#class Account(models.Model):
