import request from '@/utils/request'

// 查询调研报告材料列表
export function listRepo(query) {
  return request({
    url: '/repo/repo/list',
    method: 'get',
    params: query
  })
}

// 查询调研报告材料详细
export function getRepo(id) {
  return request({
    url: '/repo/repo/' + id,
    method: 'get'
  })
}

// 新增调研报告材料
export function addRepo(data) {
  return request({
    url: '/repo/repo',
    method: 'post',
    data: data
  })
}

// 修改调研报告材料
export function updateRepo(data) {
  return request({
    url: '/repo/repo',
    method: 'put',
    data: data
  })
}

// 删除调研报告材料
export function delRepo(id) {
  return request({
    url: '/repo/repo/' + id,
    method: 'delete'
  })
}
