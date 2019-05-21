from django.shortcuts import render
from django.http import HttpResponse
from django.contrib.auth.decorators import login_required
from django.contrib.auth.models import User

# Create your views here.
def index(request):
    context ={
        'title' : "Home Page",
    }
    return render(request, "prof/index.html", context)

@login_required
def get_user_profile(request, username):
    if request.user.username != username:
        return HttpResponse("No permission")
    user = User.objects.get(username=username)
    return render(request, 'user_profile.html', {"user":user})