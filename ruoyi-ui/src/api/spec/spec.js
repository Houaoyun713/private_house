import request from '@/utils/request'

// 查询科技专报材料列表
export function listSpec(query) {
  return request({
    url: '/spec/spec/list',
    method: 'get',
    params: query
  })
}

// 查询科技专报材料详细
export function getSpec(id) {
  return request({
    url: '/spec/spec/' + id,
    method: 'get'
  })
}

// 新增科技专报材料
export function addSpec(data) {
  return request({
    url: '/spec/spec',
    method: 'post',
    data: data
  })
}

// 修改科技专报材料
export function updateSpec(data) {
  return request({
    url: '/spec/spec',
    method: 'put',
    data: data
  })
}

// 删除科技专报材料
export function delSpec(id) {
  return request({
    url: '/spec/spec/' + id,
    method: 'delete'
  })
}
