.class public Lorg/adaway/ui/HelpFragmentHtml;
.super Lcom/actionbarsherlock/app/SherlockFragment;
.source "HelpFragmentHtml.java"


# static fields
.field public static final ARG_HTML_FILE:Ljava/lang/String; = "htmlFile"


# instance fields
.field private htmlFile:I

.field private mActivity:Landroid/app/Activity;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/actionbarsherlock/app/SherlockFragment;-><init>()V

    return-void
.end method

.method static newInstance(I)Lorg/adaway/ui/HelpFragmentHtml;
    .registers 4
    .param p0, "htmlFile"    # I

    .prologue
    .line 46
    new-instance v1, Lorg/adaway/ui/HelpFragmentHtml;

    invoke-direct {v1}, Lorg/adaway/ui/HelpFragmentHtml;-><init>()V

    .line 49
    .local v1, "f":Lorg/adaway/ui/HelpFragmentHtml;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 50
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "htmlFile"

    invoke-virtual {v0, v2, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 51
    invoke-virtual {v1, v0}, Lorg/adaway/ui/HelpFragmentHtml;->setArguments(Landroid/os/Bundle;)V

    .line 53
    return-object v1
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .registers 10
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 69
    invoke-virtual {p0}, Lorg/adaway/ui/HelpFragmentHtml;->getArguments()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "htmlFile"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    iput v3, p0, Lorg/adaway/ui/HelpFragmentHtml;->htmlFile:I

    .line 71
    invoke-virtual {p0}, Lorg/adaway/ui/HelpFragmentHtml;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iput-object v3, p0, Lorg/adaway/ui/HelpFragmentHtml;->mActivity:Landroid/app/Activity;

    .line 73
    new-instance v1, Landroid/widget/ScrollView;

    iget-object v3, p0, Lorg/adaway/ui/HelpFragmentHtml;->mActivity:Landroid/app/Activity;

    invoke-direct {v1, v3}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 74
    .local v1, "scroller":Landroid/widget/ScrollView;
    new-instance v2, Lorg/sufficientlysecure/htmltextview/HtmlTextView;

    iget-object v3, p0, Lorg/adaway/ui/HelpFragmentHtml;->mActivity:Landroid/app/Activity;

    invoke-direct {v2, v3}, Lorg/sufficientlysecure/htmltextview/HtmlTextView;-><init>(Landroid/content/Context;)V

    .line 77
    .local v2, "text":Lorg/sufficientlysecure/htmltextview/HtmlTextView;
    const/4 v3, 0x1

    const/high16 v4, 0x41800000    # 16.0f

    iget-object v5, p0, Lorg/adaway/ui/HelpFragmentHtml;->mActivity:Landroid/app/Activity;

    invoke-virtual {v5}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    invoke-static {v3, v4, v5}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v3

    float-to-int v0, v3

    .line 79
    .local v0, "padding":I
    const/4 v3, 0x0

    invoke-virtual {v2, v0, v0, v0, v3}, Lorg/sufficientlysecure/htmltextview/HtmlTextView;->setPadding(IIII)V

    .line 81
    invoke-virtual {v1, v2}, Landroid/widget/ScrollView;->addView(Landroid/view/View;)V

    .line 84
    invoke-virtual {p0}, Lorg/adaway/ui/HelpFragmentHtml;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget v4, p0, Lorg/adaway/ui/HelpFragmentHtml;->htmlFile:I

    invoke-virtual {v2, v3, v4}, Lorg/sufficientlysecure/htmltextview/HtmlTextView;->setHtmlFromRawResource(Landroid/content/Context;I)V

    .line 87
    invoke-virtual {p0}, Lorg/adaway/ui/HelpFragmentHtml;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x1060006

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Lorg/sufficientlysecure/htmltextview/HtmlTextView;->setTextColor(I)V

    .line 89
    return-object v1
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .registers 3
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 63
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 64
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lorg/adaway/ui/HelpFragmentHtml;->setUserVisibleHint(Z)V

    .line 65
    return-void
.end method
