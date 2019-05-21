from django.urls import include, path
from . import views

app_name = 'prof' # required since Django 2.0
urlpatterns = [
    path('', views.index, name="home"),
    path('<username>', views.get_user_profile),
]