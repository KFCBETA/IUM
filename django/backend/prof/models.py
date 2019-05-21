from django.db import models
from django.contrib.auth.models import User
from django.db.models.signals import post_save
from django.dispatch import receiver
from django.core.exceptions import ObjectDoesNotExist

# Create your models here.

class Profile(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    user_name = models.CharField(max_length = 50)
    user_bio = models.TextField()

    def __str__(self):
        return "User name: %s, bio: %s" % (self.user_name, self.user_bio)


class Account(models.Model):
    account_id = models.CharField(max_length = 100)
    profile = models.ForeignKey(Profile, on_delete=models.CASCADE)
    # TODO: what else

    def __str__(self):
        return self.account_id

@receiver(post_save, sender=User)
def create_user_profile(sender, instance, created, **kwargs):
    try:
        instance.profile.save()
    except ObjectDoesNotExist:
        Profile.objects.create(user=instance)