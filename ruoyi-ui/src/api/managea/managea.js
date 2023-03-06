import request from '@/utils/request'

// 查询操作日志列表
export function listManagea(query) {
  return request({
    url: '/managea/managea/list',
    method: 'get',
    params: query
  })
}

// 查询操作日志详细
export function getManagea(id) {
  return request({
    url: '/managea/managea/' + id,
    method: 'get'
  })
}

// 新增操作日志
export function addManagea(data) {
  return request({
    url: '/managea/managea',
    method: 'post',
    data: data
  })
}

// 修改操作日志
export function updateManagea(data) {
  return request({
    url: '/managea/managea',
    method: 'put',
    data: data
  })
}

// 删除操作日志
export function delManagea(id) {
  return request({
    url: '/managea/managea/' + id,
    method: 'delete'
  })
}
