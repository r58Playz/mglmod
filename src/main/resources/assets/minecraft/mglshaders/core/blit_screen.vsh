#version 460

layout(location = 0) in vec3 Position;
layout(location = 1) in vec2 UV;
layout(location = 2) in vec4 Color;

layout(location = 0) uniform mat4 ModelViewMat;
layout(location = 1) uniform mat4 ProjMat;

layout(location = 3) out vec2 texCoord;
layout(location = 4) out vec4 vertexColor;

void main() {
    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);

    texCoord = UV;
    vertexColor = Color;
}
