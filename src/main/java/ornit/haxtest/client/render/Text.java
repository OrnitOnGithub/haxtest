package ornit.haxtest.client.render;

public class Text {
    /*
    public int draw(     String text,
    float x,
    float y,
    int color,
    boolean shadow,
    Matrix4f matrix,
    VertexConsumerProvider vertexConsumers,
    TextRenderer. TextLayerType layerType,
    int backgroundColor,
    int light
     */
    public String text;
    public float x;
    public float y;
    public int color;

    public Text(String text, float x, float y, int color) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void Draw() {
        RenderUtils.drawText(this.text, this.x, this.y, this.color);
    }
}

