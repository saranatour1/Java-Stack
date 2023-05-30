from django.shortcuts import render ,redirect

# Create your views here.
from django.http import HttpResponse
from textblob import TextBlob


def index(request):
    num_visits = request.session.get('blob')
    context = {'h':num_visits}
    return render(request, "chat.html" , context=context)

def formInput(request):
    kIn = request.POST['thisInput']
    # print(request.POST['thisInput'])
    blob = TextBlob(kIn)
    sentiment = blob.sentiment.polarity
    # sentiment = str(blob)
    print(sentiment)
    request.session["blob"] = sentiment
    return redirect("/")








