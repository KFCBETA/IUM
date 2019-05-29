from django.shortcuts import render
from django.http import HttpResponse
from django.contrib.auth.decorators import login_required
from django.contrib.auth.models import User
from rest_framework import viewsets, permissions
from rest_framework.response import Response
from .permissions import IsOwnerOrAdmin
from .models import Profile, Account
from .serializers import ProfileSerializer, UserSerializer
import requests

class AllUserView(viewsets.ModelViewSet):
    queryset = User.objects.all()
    serializer_class = UserSerializer
    permission_classes = (permissions.IsAuthenticated,
                          IsOwnerOrAdmin)
    def get_queryset(self):
        if self.request.user.is_staff:
            return User.objects.all()
        else:
            return User.objects.filter(id=self.request.user.id)


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