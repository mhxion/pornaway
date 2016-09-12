.class final Lorg/adaway/ui/HelpActivity$TabsAdapter$TabInfo;
.super Ljava/lang/Object;
.source "HelpActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/adaway/ui/HelpActivity$TabsAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "TabInfo"
.end annotation


# instance fields
.field private final args:Landroid/os/Bundle;

.field private final clss:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Ljava/lang/Class;Landroid/os/Bundle;)V
    .registers 3
    .param p2, "_args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .prologue
    .line 145
    .local p1, "_class":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 146
    iput-object p1, p0, Lorg/adaway/ui/HelpActivity$TabsAdapter$TabInfo;->clss:Ljava/lang/Class;

    .line 147
    iput-object p2, p0, Lorg/adaway/ui/HelpActivity$TabsAdapter$TabInfo;->args:Landroid/os/Bundle;

    .line 148
    return-void
.end method

.method static synthetic access$000(Lorg/adaway/ui/HelpActivity$TabsAdapter$TabInfo;)Ljava/lang/Class;
    .registers 2
    .param p0, "x0"    # Lorg/adaway/ui/HelpActivity$TabsAdapter$TabInfo;

    .prologue
    .line 141
    iget-object v0, p0, Lorg/adaway/ui/HelpActivity$TabsAdapter$TabInfo;->clss:Ljava/lang/Class;

    return-object v0
.end method

.method static synthetic access$100(Lorg/adaway/ui/HelpActivity$TabsAdapter$TabInfo;)Landroid/os/Bundle;
    .registers 2
    .param p0, "x0"    # Lorg/adaway/ui/HelpActivity$TabsAdapter$TabInfo;

    .prologue
    .line 141
    iget-object v0, p0, Lorg/adaway/ui/HelpActivity$TabsAdapter$TabInfo;->args:Landroid/os/Bundle;

    return-object v0
.end method
