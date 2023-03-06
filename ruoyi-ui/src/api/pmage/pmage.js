import request from '@/utils/request'

// 查询权限管理列表
export function listPmage(query) {
  return request({
    url: '/pmage/pmage/list',
    method: 'get',
    params: query
  })
}

// 查询权限管理详细
export function getPmage(id) {
  return request({
    url: '/pmage/pmage/' + id,
    method: 'get'
  })
}

// 新增权限管理
export function addPmage(data) {
  return request({
    url: '/pmage/pmage',
    method: 'post',
    data: data
  })
}

// 修改权限管理
export function updatePmage(data) {
  return request({
    url: '/pmage/pmage',
    method: 'put',
    data: data
  })
}

// 删除权限管理
export function delPmage(id) {
  return request({
    url: '/pmage/pmage/' + id,
    method: 'delete'
  })
}
