from django.db import models
from django.contrib.auth.models import User
from django.db.models.signals import post_save
from django.dispatch import receiver

# Create your models here.

class Profile(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    user_name = models.CharField(max_length = 50)
    user_email = models.EmailField()

    def __str__(self):
        return "User name: %s, email: %s" % (self.user_name, self.user_email)


class Account(models.Model):
    account_id = models.CharField(max_length = 100)
    profile = models.ForeignKey(Profile, on_delete=models.CASCADE)
    # TODO: what else

    def __str__(self):
        return self.account_id

@receiver(post_save, sender=User)
def create_user_profile(sender, instance, created, **kwargs):
    if created:
        Profile.object.create(user=instance)

@receiver(post_save, sender=User)
def save_user_profile(sender, instance, **kwargs):
    instance.profile.save()