.class public Lorg/adaway/ui/ListsActivity$TabListener;
.super Ljava/lang/Object;
.source "ListsActivity.java"

# interfaces
.implements Lcom/actionbarsherlock/app/ActionBar$TabListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/adaway/ui/ListsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TabListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Landroid/support/v4/app/Fragment;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/actionbarsherlock/app/ActionBar$TabListener;"
    }
.end annotation


# instance fields
.field private final mActivity:Landroid/app/Activity;

.field private final mClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end field

.field private mFragment:Landroid/support/v4/app/Fragment;

.field private final mTag:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/Class;)V
    .registers 4
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "tag"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 169
    .local p0, "this":Lorg/adaway/ui/ListsActivity$TabListener;, "Lorg/adaway/ui/ListsActivity$TabListener<TT;>;"
    .local p3, "clz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 170
    iput-object p1, p0, Lorg/adaway/ui/ListsActivity$TabListener;->mActivity:Landroid/app/Activity;

    .line 171
    iput-object p2, p0, Lorg/adaway/ui/ListsActivity$TabListener;->mTag:Ljava/lang/String;

    .line 172
    iput-object p3, p0, Lorg/adaway/ui/ListsActivity$TabListener;->mClass:Ljava/lang/Class;

    .line 173
    return-void
.end method


# virtual methods
.method public onTabReselected(Lcom/actionbarsherlock/app/ActionBar$Tab;Landroid/support/v4/app/FragmentTransaction;)V
    .registers 3
    .param p1, "tab"    # Lcom/actionbarsherlock/app/ActionBar$Tab;
    .param p2, "ft"    # Landroid/support/v4/app/FragmentTransaction;

    .prologue
    .line 177
    .local p0, "this":Lorg/adaway/ui/ListsActivity$TabListener;, "Lorg/adaway/ui/ListsActivity$TabListener<TT;>;"
    return-void
.end method

.method public onTabSelected(Lcom/actionbarsherlock/app/ActionBar$Tab;Landroid/support/v4/app/FragmentTransaction;)V
    .registers 8
    .param p1, "tab"    # Lcom/actionbarsherlock/app/ActionBar$Tab;
    .param p2, "ignoredFt"    # Landroid/support/v4/app/FragmentTransaction;

    .prologue
    .line 186
    .local p0, "this":Lorg/adaway/ui/ListsActivity$TabListener;, "Lorg/adaway/ui/ListsActivity$TabListener<TT;>;"
    iget-object v2, p0, Lorg/adaway/ui/ListsActivity$TabListener;->mActivity:Landroid/app/Activity;

    check-cast v2, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 187
    .local v0, "fragMgr":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 189
    .local v1, "ft":Landroid/support/v4/app/FragmentTransaction;
    iget-object v2, p0, Lorg/adaway/ui/ListsActivity$TabListener;->mActivity:Landroid/app/Activity;

    iget-object v3, p0, Lorg/adaway/ui/ListsActivity$TabListener;->mClass:Ljava/lang/Class;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    iput-object v2, p0, Lorg/adaway/ui/ListsActivity$TabListener;->mFragment:Landroid/support/v4/app/Fragment;

    .line 190
    const v2, 0x7f0e0053

    iget-object v3, p0, Lorg/adaway/ui/ListsActivity$TabListener;->mFragment:Landroid/support/v4/app/Fragment;

    iget-object v4, p0, Lorg/adaway/ui/ListsActivity$TabListener;->mTag:Ljava/lang/String;

    invoke-virtual {v1, v2, v3, v4}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 191
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 192
    return-void
.end method

.method public onTabUnselected(Lcom/actionbarsherlock/app/ActionBar$Tab;Landroid/support/v4/app/FragmentTransaction;)V
    .registers 6
    .param p1, "tab"    # Lcom/actionbarsherlock/app/ActionBar$Tab;
    .param p2, "ignoredFt"    # Landroid/support/v4/app/FragmentTransaction;

    .prologue
    .line 196
    .local p0, "this":Lorg/adaway/ui/ListsActivity$TabListener;, "Lorg/adaway/ui/ListsActivity$TabListener<TT;>;"
    iget-object v2, p0, Lorg/adaway/ui/ListsActivity$TabListener;->mActivity:Landroid/app/Activity;

    check-cast v2, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 197
    .local v0, "fragMgr":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 199
    .local v1, "ft":Landroid/support/v4/app/FragmentTransaction;
    iget-object v2, p0, Lorg/adaway/ui/ListsActivity$TabListener;->mFragment:Landroid/support/v4/app/Fragment;

    if-eqz v2, :cond_15

    .line 201
    iget-object v2, p0, Lorg/adaway/ui/ListsActivity$TabListener;->mFragment:Landroid/support/v4/app/Fragment;

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentTransaction;->remove(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 204
    :cond_15
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 205
    return-void
.end method
