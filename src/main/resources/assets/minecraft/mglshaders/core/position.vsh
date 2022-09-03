#version 460

#moj_import <fog.glsl>

layout(location = 0) in vec3 Position;

layout(location = 0) uniform mat4 ProjMat;
layout(location = 1) uniform mat4 ModelViewMat;
layout(location = 2) uniform int FogShape;

layout(location = 1) out float vertexDistance;

void main() {
    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);

    vertexDistance = fog_distance(ModelViewMat, Position, FogShape);
}
