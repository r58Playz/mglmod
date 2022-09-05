#version 460

layout(location = 0) in vec3 Position;
layout(location = 1) in vec4 Color;
layout(location = 2) in vec2 UV0;
layout(location = 3) in vec2 UV2;

layout(location = 0) uniform mat4 ModelViewMat;
layout(location = 1) uniform mat4 ProjMat;

layout(location = 4) out vec4 vertexColor;
layout(location = 5) out vec2 texCoord0;
layout(location = 6) out vec2 texCoord2;

void main() {
    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);

    vertexColor = Color;
    texCoord0 = UV0;
    texCoord2 = UV2;
}
