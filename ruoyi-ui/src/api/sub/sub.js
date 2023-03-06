import request from '@/utils/request'

// 查询课题维护列表
export function listSub(query) {
  return request({
    url: '/sub/sub/list',
    method: 'get',
    params: query
  })
}

// 查询课题维护详细
export function getSub(id) {
  return request({
    url: '/sub/sub/' + id,
    method: 'get'
  })
}

// 新增课题维护
export function addSub(data) {
  return request({
    url: '/sub/sub',
    method: 'post',
    data: data
  })
}

// 修改课题维护
export function updateSub(data) {
  return request({
    url: '/sub/sub',
    method: 'put',
    data: data
  })
}

// 删除课题维护
export function delSub(id) {
  return request({
    url: '/sub/sub/' + id,
    method: 'delete'
  })
}
