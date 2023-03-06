import request from '@/utils/request'

// 查询通知发布列表
export function listNotire(query) {
  return request({
    url: '/notire/notire/list',
    method: 'get',
    params: query
  })
}

// 查询通知发布详细
export function getNotire(id) {
  return request({
    url: '/notire/notire/' + id,
    method: 'get'
  })
}

// 新增通知发布
export function addNotire(data) {
  return request({
    url: '/notire/notire',
    method: 'post',
    data: data
  })
}

// 修改通知发布
export function updateNotire(data) {
  return request({
    url: '/notire/notire',
    method: 'put',
    data: data
  })
}

// 删除通知发布
export function delNotire(id) {
  return request({
    url: '/notire/notire/' + id,
    method: 'delete'
  })
}
