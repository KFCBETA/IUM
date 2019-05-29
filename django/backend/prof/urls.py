from django.urls import include, path
from . import views
from rest_framework import routers

router = routers.DefaultRouter()
router.register('user', views.UserView)

app_name = 'prof' # required since Django 2.0
urlpatterns = [
    path('', views.index, name="home"),
    path('prof/<username>', views.get_user_profile),
    path('api', include(router.urls)),
]